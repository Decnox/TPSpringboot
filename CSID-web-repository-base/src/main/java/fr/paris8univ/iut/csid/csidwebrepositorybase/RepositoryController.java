package fr.paris8univ.iut.csid.csidwebrepositorybase;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/repositories")
public class RepositoryController {
	
	
	private final RepositoryService repositoryService;
	
	@Autowired
	public RepositoryController(RepositoryService repositoryService) {
		this.repositoryService=repositoryService;
	}
	
	@GetMapping
	public List<GitRepository> getRepositories(){
		return repositoryService.getRepositories();
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<GitRepository> findOneRepository(@PathVariable String name) throws URISyntaxException {
		return repositoryService.findOneRepository(name)	
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());

	}
	
	@PostMapping
	public ResponseEntity<GitRepository> creatRepository(@RequestBody GitRepository gitRepository){
		repositoryService.creatRepository(gitRepository);
		return null;
	}
	
	@PutMapping("/{name}")
	public void putRepository(@PathVariable String name,@RequestBody GitRepository gitRepository) {
		repositoryService.putRepository( name, gitRepository);
	}
	
	@PatchMapping("/{name}")
	public void patchRepository(@PathVariable String name,@RequestBody GitRepository gitRepository) {
		repositoryService.patchRepository(name,gitRepository);
	}
	
	@DeleteMapping("/{name}")
	public void deleteRepository(@PathVariable String name) {

		repositoryService.deleteRepository(name);
	}


}
