package ra.exercise.service.ss3;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.exercise.entity.ss3.Book;
import ra.exercise.service.IGeneric;

public interface BookService extends IGeneric<Book, Integer> {
    Page<Book> findByKeyword(String keyword, Pageable pageable);
}
