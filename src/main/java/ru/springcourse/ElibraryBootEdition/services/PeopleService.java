package ru.springcourse.ElibraryBootEdition.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.springcourse.ElibraryBootEdition.model.Person;
import ru.springcourse.ElibraryBootEdition.repositories.PeopleRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PeopleService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> index(){
        return peopleRepository.findAll();
    }

    public Person show(int id){
        return peopleRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Person person){
        peopleRepository.save(person);
    }

    @Transactional
    public void update(int id, Person person){
        person.setId_person(id);
        peopleRepository.save(person);
    }

    @Transactional
    public void delete(int id){
        peopleRepository.deleteById(id);
    }

/*    public List<Book> findBooksByPersonId(int id){
        Optional<Person> person = peopleRepository.findById(id);
        return person.get().getBooks();
    }*/

    public void test() {
        System.out.println("Testing here with debug. Inside Hibernate Transaction");
    }
}
