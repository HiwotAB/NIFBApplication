package hiwotab.roboresumeapplication.repositories;

import hiwotab.roboresumeapplication.Models.Resume;
import org.springframework.data.repository.CrudRepository;

public interface ResumeRepostory extends CrudRepository<Resume,Long> {
    //Iterable<Book>findByBookCategoriesContainsAndBookCategories;
   // Iterable<Resume>findByBookAuthor(String listAuthor);
}
