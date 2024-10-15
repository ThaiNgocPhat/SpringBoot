package ra.exercise.service.ss2.bt4.projects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.exercise.entity.ss2.bt4.Projects;
import ra.exercise.repository.ss2.bt4.ProjectsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectsServiceImpl implements ProjectsService{
    @Autowired
    private ProjectsRepository projectsRepository;
    @Override
    public List<Projects> findAll() {
        return projectsRepository.findAll();
    }

    @Override
    public Optional<Projects> findById(Integer id) {
        return projectsRepository.findById(id);
    }

    @Override
    public Projects save(Projects projects) {
        return projectsRepository.save(projects);
    }

    @Override
    public void delete(Integer id) {
        projectsRepository.deleteById(id);
    }

    @Override
    public void update(Projects projects) {
        projectsRepository.save(projects);
    }
}
