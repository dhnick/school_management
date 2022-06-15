package za.ac.cput.school_management.repository.employee;


import za.ac.cput.school_management.domain.employee.EmployeeAddress;

import java.util.*;

/* EmployeeAddressRepository.Java
 *  Entity for EmployeeAddressRepository
 *  Author: Yasmeen Nel (219250553)
 *  Date: 13 June 2022
 * */

public class EmployeeAddressRepository implements IEmployeeAddressRepository{

    private static EmployeeAddressRepository repository = null;
    private List<EmployeeAddress> staffDB ;

    private EmployeeAddressRepository(){
        this.staffDB = new ArrayList<>();
    }
    public static EmployeeAddressRepository getRepository(){
        if(repository == null){
            repository= new EmployeeAddressRepository();
        }
        return repository;
    }

    @Override
    public EmployeeAddress save(EmployeeAddress employeeAddress) {
        Optional<EmployeeAddress> read = read(employeeAddress.getStaffId());
        if(read.isPresent()){
            delete(read.get());
        }
        this.staffDB.add(employeeAddress);
        return employeeAddress;
    }

    @Override
    public Optional<EmployeeAddress> read(String staffId) {
        return this.staffDB.stream().filter(s -> s.getStaffId().equalsIgnoreCase(staffId)).findFirst();
    }


    @Override
    public void delete(EmployeeAddress employeeAddress) {
        this.staffDB.remove(employeeAddress);
    }

    @Override
    public List<EmployeeAddress> getAll() {
        return this.staffDB;
    }
}


