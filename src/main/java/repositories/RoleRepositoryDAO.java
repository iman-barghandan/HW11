package repositories;

import domains.Role;

public class RoleRepositoryDAO extends BaseRepositoryDAO<Role,Long> {
    private static RoleRepositoryDAO roleRepositoryDAO;
    private RoleRepositoryDAO(){}

    public static RoleRepositoryDAO getInstance(){
        if (roleRepositoryDAO==null){
            roleRepositoryDAO = new RoleRepositoryDAO();
        }
        return roleRepositoryDAO;
    }


    @Override
    protected Class<Role> getEntityClass() {
        return Role.class;
    }
}
