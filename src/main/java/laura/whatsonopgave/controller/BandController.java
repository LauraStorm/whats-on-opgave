package laura.whatsonopgave.controller;

import laura.whatsonopgave.model.Band;
import laura.whatsonopgave.service.IBandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class BandController {
    private IBandService bandService;

    public BandController(IBandService bandService) {
        this.bandService = bandService;
    }

    @PostMapping("/createBand")
    public ResponseEntity<String> createBand (@RequestBody Band band){
        String bandMessage ="";
        if (bandService.save(band) != null){
            bandMessage = "Oprettet band: " + band.getName();
        } else {
            bandMessage = "Fejl i band oprettelse af: " + band.getName();
        }

        return new ResponseEntity<>(bandMessage, HttpStatus.OK);
    }

    @GetMapping("/allBands")
    public ResponseEntity<Set<Band>> getAllBands (){
        Set<Band> allBands = bandService.findAll();
        return new ResponseEntity<>(allBands, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBand")
    public ResponseEntity<Long> deleteBandById(@RequestParam ("id") Long id){
        bandService.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping("/updateBand")
    public ResponseEntity<Band> updateBand (@RequestParam ("id") long id, @RequestBody Band band){
        //Find band via id
        Band bandToUpdate = bandService.findById(id).get();
        bandToUpdate.setName(band.getName());
        bandService.save(band);
        return new ResponseEntity<>(band, HttpStatus.OK);
    }

    @GetMapping("/getBandByName")
    public ResponseEntity<List<Band>> getBandByName (String name){
        return new ResponseEntity<> (bandService.findBandByName(name),HttpStatus.OK);
    }
}
