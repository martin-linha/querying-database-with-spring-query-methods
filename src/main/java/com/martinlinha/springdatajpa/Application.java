package com.martinlinha.springdatajpa;

import com.martinlinha.springdatajpa.entities.Address;
import com.martinlinha.springdatajpa.entities.User;
import com.martinlinha.springdatajpa.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return (args) -> {
            userRepository.save(
                    new User("Anakin Skywalker", 11, "anakin@gmail.com", "00123012300",
                            new Address("Street 1", "San Francisco", "California", 11000)
                            , null));
            userRepository.save(
                    new User("Leia Organa", 33, "leiaorgana@gmail.com", "0473729",
                            new Address("Street 2", "Los Angeles", "California", 31233)
                            , null));
            userRepository.save(
                    new User("Boba Fett", 23, "boba_fett@gmail.com", "12399215",
                            new Address("Street 9", "San Diego", "California", 12367)
                            , new Address("Street 3", "San Diego", "California", 12311)));
            userRepository.save(
                    new User("Padme Amidala", 31, "padme@gmail.com", "221-213-222",
                            null,
                            new Address("Street 4", "Las Vegas", "Nevada", 66331)));
            userRepository.save(
                    new User("Kylo Ren", 19, "kylo@gmail.com", "1231599-134",
                            null,
                            new Address("Street 5", "Phoenix", "Arizona", 14123)));

            System.out.println("-- findAllByEmail");
            userRepository.findAllByEmail("leiaorgana@gmail.com").forEach(System.out::println);

            System.out.println("-- findAllByNameEndingWith");
            userRepository.findAllByNameEndingWith("Ren").forEach(System.out::println);

            System.out.println("-- findAllByNameEqualsOrNameEquals");
            userRepository.findAllByNameEqualsOrNameEquals("Boba Fett", "Padme Amidala").forEach(System.out::println);

            System.out.println("-- findByHomeAddressCountry");
            userRepository.findByHomeAddressCountry("California").forEach(System.out::println);

            System.out.println("-- findByHomeAddressCityAllIgnoreCase");
            userRepository.findByHomeAddressCityAllIgnoreCase("san diego").forEach(System.out::println);

            System.out.println("-- findFirstByWorkAddressZipCode");
            System.out.println(userRepository.findFirstByWorkAddressZipCode(12311));

            System.out.println("-- findTop3ByHomeAddressCountry");
            userRepository.findTop2ByHomeAddressCountry("California").forEach(System.out::println);

            System.out.println("-- findByHomeAddressCountry");
            userRepository.findByHomeAddressCountry("California", new PageRequest(1, 2)).forEach(System.out::println);

            System.out.println("-- allUsersBetweenYears");
            userRepository.allUsersBetweenAge(20, 35).forEach(System.out::println);
        };
    }
}
