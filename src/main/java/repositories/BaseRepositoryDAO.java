package repositories;

import entityManagerFactory.EntityManagerRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public abstract class BaseRepositoryDAO<Entity,Id extends Number> {
    protected abstract Class<Entity> getEntityClass();

    EntityManager entityManager = EntityManagerRepository.getEntityManager();


    public List<Entity> selectAll()
    {
        entityManager.getTransaction().begin();
        TypedQuery<Entity> query = entityManager.createQuery("select entity from " + getEntityClass().getName() + " entity" , getEntityClass());
        List<Entity> entityList = query.getResultList();
        entityManager.getTransaction().commit();
        return entityList;
    }

    public Entity selectById(Id id){
        entityManager.getTransaction().begin();
        Entity entity = entityManager.find(getEntityClass(), id);
        entityManager.getTransaction().commit();
        return entity;
    }

    public Entity save(Entity entity){
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    public void remove(Entity entity){
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    public void removeById(Id id) throws Exception {
        Entity entity = selectById(id);
        if(entity==null){
            throw new Exception("this entity not exist");
        }
        remove(entity);
    }

    public Entity update(Entity entity){
        entityManager.getTransaction().begin();
        Entity merge = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return merge;
    }
}