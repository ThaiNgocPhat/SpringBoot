package ra.exercise.service.ss2.bt3;

import org.springframework.data.domain.Page;
import ra.exercise.entity.ss2.bt3.Blog;
import ra.exercise.service.IGeneric;

public interface BlogService extends IGeneric<Blog, Integer> {
    Page<Blog> findAllBlogs(int page, int size);
}
