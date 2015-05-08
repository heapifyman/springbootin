package org.heapifyman.bootin.repository;

import java.util.List;

import org.heapifyman.bootin.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends PagingAndSortingRepository<Person, Integer> {

    List<Person> findByLastName(@Param("lastName") String lastName);

}
