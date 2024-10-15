package ra.exercise.repository.ss2.bt3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.exercise.entity.ss2.bt3.Blog;
@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
