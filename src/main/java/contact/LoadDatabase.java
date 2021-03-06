package contact;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ContactRepository contactRepository) {

        return args -> {
            contactRepository.save(new Contact("Bilbo", "Baggins", "123456987", "bil@bibl.bil", "burglar"));
            contactRepository.save(new Contact("Frodo", "Baggins", "236589956","frod@frod.fr", "thief"));

            contactRepository.findAll().forEach(contact -> log.info("Preloaded " + contact));
        };
    }
}