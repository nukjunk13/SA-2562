package com.relation.backend.Advt;

import com.relation.backend.Advt.entity.Adtype;
import com.relation.backend.Advt.entity.Employee;
import com.relation.backend.Advt.entity.Sponsor;
import com.relation.backend.Advt.repository.AdtypeRepository;
import com.relation.backend.Advt.repository.EmployeeRepository;
import com.relation.backend.Advt.repository.SponsorRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class SpringBootVueApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootVueApplication.class, args);
	}

	@Bean
	ApplicationRunner init(AdtypeRepository adtypeRepository, EmployeeRepository employeeRepository, SponsorRepository sponsorRepository) {
		return args -> {

			Stream.of("แฟชั่น", "อิเล็กทรอนิกส์ & แก็ดเจ็ต", "ท่องเที่ยว & โรงแรม" ,"อาหาร & ผักและผลไม้" ,"สกินแคร์ & เครื่องสำอาง").forEach(name -> {
				Adtype adtype = new Adtype(); // สร้าง Object Adtype
				adtype.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Adtype
				adtypeRepository.save(adtype); // บันทึก Objcet ชื่อ Adtype
			});

			Stream.of("Dream", "Faii", "Man", "Snooker","Men","F").forEach(name -> {
				Employee employee = new Employee(); // สร้าง Object Employee
				employee.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Employee
				employeeRepository.save(employee); // บันทึก Objcet ชื่อ Employee
			});

			Stream.of("Coke", "Shein", "NokAir","Acer").forEach(name -> {
				Sponsor sponsor = new Sponsor(); // สร้าง Object Sponsor
				sponsor.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Sponsor
				sponsorRepository.save(sponsor); // บันทึก Objcet ชื่อ Sponsor
			});

			adtypeRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Adtype บน Terminal
			employeeRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Employee บน Terminal
			sponsorRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Sponsor บน Terminal
		};
	}

}