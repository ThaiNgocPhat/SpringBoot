package ra.exercise.controller.ss3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.exercise.entity.ss3.Book;
import ra.exercise.service.ss3.BookService;

import java.util.Optional;

@Controller
@RequestMapping("/ss3")
public class BookingController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public String listBooks(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            Model model) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        // Tìm kiếm theo từ khóa
        Page<Book> bookPage = bookService.findByKeyword(keyword, pageable);

        model.addAttribute("bookPage", bookPage);
        model.addAttribute("keyword", keyword);
        model.addAttribute("currentPage", page);
        model.addAttribute("size", size);
        model.addAttribute("sortBy", sortBy);
        return "ss3/index"; // Trả về view đúng
    }


    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "ss3/add";
    }

    @PostMapping("/add")
    public String addBook(Book book) {
        bookService.save(book);
        return "redirect:/ss3";
    }

    @GetMapping("/delete/{bookId}")
    public String deleteBook(@PathVariable("bookId") Integer id) {
        bookService.delete(id);
        return "redirect:/ss3";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
        } else {
            return "redirect:/ss3";
        }
        return "/ss3/edit";
    }


    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable Integer id, @ModelAttribute Book book) {
        book.setBookId(id);
        bookService.save(book);
        return "redirect:/ss3";
    }
}
