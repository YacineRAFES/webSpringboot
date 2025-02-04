package fr.afpa.pompey.appweb.repository;

import fr.afpa.pompey.appweb.model.Person;
import fr.afpa.pompey.appweb.config.CustomProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class PersonRepository {

    @Autowired
    private CustomProperties customProperties;

    public Iterable<Person> getPersons() {
        String baseUrl = customProperties.getApiUrl();
        String getPersonsUrl = baseUrl + "/persons";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Person>> response = restTemplate.exchange(
                getPersonsUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Person>>() {}
        );

        log.debug("get persons call: " + response.getStatusCode());

        return response.getBody();
    }

    public Person createPerson(Person person) {
        String baseUrl = customProperties.getApiUrl();
        String createPersonsUrl = baseUrl + "/person";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Person> request = new HttpEntity<>(person);
        ResponseEntity<Person> response = restTemplate.exchange(
                createPersonsUrl,
                HttpMethod.POST,
                request,
                Person.class
        );

        log.debug("create person call: " + response.getStatusCode());

        return response.getBody();

    }

    public Person getPerson(int id) {
        String baseUrl = customProperties.getApiUrl();
        String getPersonUrl = baseUrl + "/person/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Person> response = restTemplate.exchange(
                getPersonUrl,
                HttpMethod.GET,
                null,
                Person.class
        );

        log.debug("get person call: " + response.getStatusCode());

        return response.getBody();
    }

    public Person updatePerson(Person person) {
        String baseUrl = customProperties.getApiUrl();
        String updatePersonUrl = baseUrl + "/person/" + person.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Person> request = new HttpEntity<>(person);
        ResponseEntity<Person> response = restTemplate.exchange(
                updatePersonUrl,
                HttpMethod.PUT,
                request,
                Person.class
        );

        log.debug("update person call: " + response.getStatusCode());

        return response.getBody();
    }

    public void deletePerson(int id) {
        String baseUrl = customProperties.getApiUrl();
        String deletePersonUrl = baseUrl + "/person/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deletePersonUrl,
                HttpMethod.DELETE,
                null,
                Void.class
        );

        log.debug("delete person call: " + response.getStatusCode());
    }
}
