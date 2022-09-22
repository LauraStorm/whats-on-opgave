package laura.whatsonopgave.service;

import laura.whatsonopgave.model.Band;

import java.util.List;

public interface IBandService extends ICrudService <Band, Long>{
    List<Band> findBandByName(String name); //Du kan flere ting. eks. sortere ved at skrive 'findBandByNameOrderById'

}
