package ra.exercise.service.ss3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ra.exercise.entity.ss3.Book;
import ra.exercise.repository.ss3.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Page<Book> findByKeyword(String keyword, Pageable pageable) {
        String searchKeyword = "%" + keyword + "%"; // Thêm ký tự '%' cho tìm kiếm chứa
        if (keyword == null || keyword.isEmpty()) {
            return bookRepository.findAll(pageable);
        } else {
            return bookRepository.findByNameContainingOrCategoryNameContaining(searchKeyword, searchKeyword, pageable);
        }
    }


}
