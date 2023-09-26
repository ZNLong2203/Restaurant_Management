package folder;

import models.Employee;
import oop.EmployeeOOP;
import java.util.*;

public class CRUD_Employee {
    public static void main(String[] args) {
        Employee userDao = new Employee();

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap n: ");
        System.out.println("1. Insert");
        System.out.println("2. Read a user by ID");
        System.out.println("3. Update a user by ID");
        System.out.println("4. Delete a user by ID");
        long n = sc.nextLong();

        if(n==1) {
            // Create a new user
            EmployeeOOP newUser = new EmployeeOOP();
            newUser.setId(1);
            newUser.setName("John Doe");
            newUser.setTitle("Admin");
            newUser.setModifidate("2021-05-05");
            userDao.createUser(newUser);
        }
        else if(n==2) {
            // Read a user by ID
            EmployeeOOP user = userDao.getUserById(1);
            if (user != null) {
                System.out.println("User Found: " + user.getName());
            } else {
                System.out.println("User not found.");
            }
        }
        else if(n==3) {
            // Update a user
            EmployeeOOP updatedUser = new EmployeeOOP();
            updatedUser.setName("Updated Name");
            updatedUser.setTitle("Updated Role");
            updatedUser.setModifidate("2021-05-05");
            userDao.updateUserById(1, updatedUser);
        }
        else if(n==4) {
            // Delete a user
            userDao.deleteUserById(1);
        }
    }
}