package com.baitap.session09.Service;

import com.baitap.session09.Dao.CustomerDao;
import com.baitap.session09.Dao.CustomerDaoImp;
import com.baitap.session09.modal.Customer;

import java.util.List;

public class CustomerServiceImp implements CustomerService {
    public CustomerDao customerDao;
    public CustomerServiceImp() {
        customerDao = new CustomerDaoImp();
    }
    @Override
    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }
}
