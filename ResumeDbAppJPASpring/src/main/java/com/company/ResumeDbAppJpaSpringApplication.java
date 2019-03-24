package com.company;

import com.company.dao.impl.UserRepository;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ResumeDbAppJpaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumeDbAppJpaSpringApplication.class, args);
	}


//	@Autowired
//	@Qualifier("userDao1")
//	private UserDaoInter userDao;


//	@Bean
//	public CommandLineRunner run(){
//		CommandLineRunner clr = new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				List<User> list= userDao.getAll(null,null,null);
//
//				User u = list.get(0);
//				System.out.println(u);
//				u.setFirstname(u.getFirstname().toLowerCase());
//				userDao.updateUser(u);
//			}
//
//		};
//		return clr;
//
//	}

	/////////////////////
//
	@Autowired
	private UserServiceInter userService;

//	@Autowired
//	private UserRepository repo;

	@Bean
	public CommandLineRunner run() {
		CommandLineRunner clr = new CommandLineRunner(){

			@Override
			public void run(String... args) throws Exception {

				for(int i=0;i<10;i++){
					userService.getAll(null,null,null);
					User u = userService.getById(i);
					System.out.println(u);
					if(u!=null){
						u.setFirstname("Pala");
						userService.updateUser(u);
					}
//					User u1 = new User(1,)
				}

				userService.getById(6);//
			}
		};

		return clr;
	}


}
