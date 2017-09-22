package com.example.customer.service;

import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  CustomerRepository customerRepository;

  @Transactional
  @Override
  public Customer add(Customer customer) {
    return customerRepository.save( customer );
  }

  @Transactional
  @Override
  public void add(List<Customer> customers) {
    for (Customer aCustomer : customers){
      customerRepository.save(aCustomer);
    }
  }

  @Transactional
  @Override
  public Customer getById(int id) {
    return customerRepository.findOne( id );
  }

  @Transactional
  @Override
  public List<Customer> get() {
    return customerRepository.findAll();
  }

  @Transactional
  @Override
  public void update(Customer customer) {
    customerRepository.save( customer );
  }

  @Transactional
  @Override
  public void delete(int id) {
    Customer customer = customerRepository.findOne( id );
    customerRepository.delete( customer );

  }
}
