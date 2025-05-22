package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {

    public static List<Employee> findDuplicates(List<Employee> list) {
        Set<Employee> seen = new HashSet<>();
        Set<Employee> duplicates = new HashSet<>();

        for (Employee emp : list) {
            if (!seen.add(emp)) {
                duplicates.add(emp);
            }
        }

        return new LinkedList<>(duplicates);
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Employee> result = new HashMap<>();

        for (Employee emp : list) {
            if (emp == null) continue;
            int id = emp.getId();
            countMap.put(id, countMap.getOrDefault(id, 0) + 1);
            if (!result.containsKey(id)) {
                result.put(id, emp);
            }
        }
        return result;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Employee> result = new LinkedList<>();

        for (Employee emp : list) {
            if (emp == null) continue; // null öğeyi saymıyoruz

            int id = emp.getId();
            countMap.put(id, countMap.getOrDefault(id, 0) + 1);
        }

        for (Employee emp : list) {
            if (emp == null) continue; // null öğeyi eklemiyoruz

            int id = emp.getId();
            if (countMap.get(id) == 1) {
                result.add(emp);
            }
        }

        return result;
    }



    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Onur", "Gurcay"));
        employees.add(new Employee(2, "Akbel", "Tekeli Gurcay"));
        employees.add(new Employee(3, "Aden", "Gurcay"));
        employees.add(new Employee(4, "Mert", "Gurcay"));
        employees.add(new Employee(1, "Onur", "Gurcay"));
        employees.add(new Employee(2, "Akbel", "Tekeli Gurcay"));
        employees.add(new Employee(5, "Tuba", "Ilkorkor"));

        List<Employee> duplicates = findDuplicates(employees);
        System.out.println(duplicates);
        Map<Integer, Employee> uniques = findUniques(employees);
        System.out.println(uniques);
        List<Employee> cleaned = removeDuplicates(employees);
        System.out.println(cleaned);
    }
}