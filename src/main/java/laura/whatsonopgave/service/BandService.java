package laura.whatsonopgave.service;

import laura.whatsonopgave.model.Band;
import laura.whatsonopgave.repositories.BandRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BandService implements IBandService{
    private BandRepo bandRepo;

    public BandService(BandRepo bandRepo) {
        this.bandRepo = bandRepo;
    }

    @Override
    public Set<Band> findAll() {
        Set<Band> allBands = new HashSet<>();
        bandRepo.findAll().forEach(allBands::add);
        System.out.println(allBands.size());
        return allBands;
    }

    @Override
    public Band save(Band object) {
        bandRepo.save(object);
        return object;
    }

    @Override
    public void delete(Band object) {
        bandRepo.delete(object);
        System.out.println("You deleted: " + object);
    }

    @Override
    public void deleteById(Long aLong) {
        bandRepo.deleteById(aLong);
        System.out.println("You deleted Band with id : " + aLong );
    }

    @Override
    public Optional<Band> findById(Long aLong) {
        return bandRepo.findById(aLong);
    }

    @Override
    public List<Band> findBandByName(String name) {
        return bandRepo.findBandByName(name);
    }
}
