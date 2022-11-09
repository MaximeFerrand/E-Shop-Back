package ajc.sopra.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ajc.sopra.eshop.exception.ArtisanException;
import ajc.sopra.eshop.exception.IdException;
import ajc.sopra.eshop.model.Artisan;
import ajc.sopra.eshop.repository.ArtisanRepository;
import ajc.sopra.eshop.repository.ProductRepository;

@Service
public class ArtisanService {

	@Autowired
	private ArtisanRepository artisanRepo;
	
	@Autowired
	private ProductRepository productRepo;

	public List<Artisan> findAll() {
		return artisanRepo.findAll();
	}


	public Artisan findByIdFetchProduits(Integer id) {
		return artisanRepo.findByIdFetchingProducts(id).orElseThrow(IdException::new);
	}

	public Artisan findById(Integer id) {
		return artisanRepo.findById(id).orElseThrow(IdException::new);
	}

	public Artisan save(Artisan artisan) {
		if (artisan.getCompany() == null || artisan.getCompany().isBlank()) {
			throw new ArtisanException();
		}
	
		return artisanRepo.save(artisan);
	}

	public void deleteById(Integer id) {
		//productRepo.deleteByArtisan(findById(id));
		artisanRepo.deleteById(id);
	}
}
