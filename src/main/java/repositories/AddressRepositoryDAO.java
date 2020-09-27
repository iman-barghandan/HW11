package repositories;

import domains.Address;
import domains.Role;

public class AddressRepositoryDAO extends BaseRepositoryDAO<Address,Long> {
    private static AddressRepositoryDAO addressRepositoryDAO;
    private AddressRepositoryDAO(){}

    public static AddressRepositoryDAO getInstance(){
        if (addressRepositoryDAO==null){
            addressRepositoryDAO = new AddressRepositoryDAO();
        }
        return addressRepositoryDAO;
    }

    @Override
    protected Class<Address> getEntityClass() {
        return Address.class;
    }
}
