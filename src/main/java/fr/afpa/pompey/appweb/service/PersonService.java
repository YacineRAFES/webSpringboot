package fr.afpa.pompey.appweb.service;

import fr.afpa.pompey.appweb.model.Person;
import fr.afpa.pompey.appweb.repository.PersonRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person getPerson(int id) {
        return personRepository.getPerson(id);
    }

    public Iterable<Person> getPersons() {
        return personRepository.getPersons();
    }

    public void deletePerson(final int id) {
        personRepository.deletePerson(id);
    }

    public Person savePerson(Person person) {
        Person saved;

        person.setPrenom(person.getPrenom().toUpperCase());

        if(person.getId() == null) {
            saved = personRepository.createPerson(person);
        } else {
            saved = personRepository.updatePerson(person);
        }
        return saved;
    }
}
