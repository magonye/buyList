package com.mike.buyList.place.controller;

import com.mike.buyList.place.entity.Place;
import com.mike.buyList.place.exception.PlaceAlreadyExistException;
import com.mike.buyList.place.exception.PlaceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mike on 8/8/15..
 */
@Controller
@RequestMapping("/places")
public class PlacesController {

    private static Map<Integer, Place> places = new HashMap<Integer, Place>();

    static {
        places.put(0, new Place(0l, "Super"));
        places.put(1, new Place(1l, "Ikea"));
        places.put(2, new Place(2l, "Ferreteria"));
        places.put(3, new Place(3l, "Amazon"));
        places.put(4, new Place(4l, "Decathlon"));
        places.put(5, new Place(5l, "Sin especificar"));
    }

    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
    public List<Place> getAll(){
        return  new ArrayList<Place>(places.values());
    }

    @RequestMapping(method= RequestMethod.GET, value = "{id}")
    @ResponseBody
    public Place getOne(@PathVariable int id) throws PlaceNotFoundException {
        return getPlace(id);
    }

    @RequestMapping(method= RequestMethod.PUT, value = "{id}")
    @ResponseBody
    public Place update(@PathVariable int id, @RequestBody Place place) throws PlaceNotFoundException {
        Place yourPlace = getPlace(id);
        places.put(id, place);
        return null;
    }

    @RequestMapping(method= RequestMethod.POST)
    @ResponseBody
    public Place create(@RequestBody Place place) throws PlaceAlreadyExistException{
        Place yourPlace = places.get(place.getId().intValue());
        if (yourPlace != null){
            throw new PlaceAlreadyExistException();
        }
        places.put(place.getId().intValue(), place);
        return null;
    }

    @RequestMapping(method=RequestMethod.DELETE, value = "{id}")
    @ResponseBody
    public void delete(@PathVariable int id) throws PlaceNotFoundException {
        Place yourPlace = getPlace(id);
        places.remove(id);
    }

    private Place getPlace(int id) throws PlaceNotFoundException {
        Place yourPlace = places.get(id);
        if (yourPlace == null) {
            throw new PlaceNotFoundException();
        }
        return yourPlace;
    }
}
