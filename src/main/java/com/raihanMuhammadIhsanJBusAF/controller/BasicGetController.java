package com.raihanMuhammadIhsanJBusAF.controller;

import com.raihanMuhammadIhsanJBusAF.Algorithm;
import com.raihanMuhammadIhsanJBusAF.dbjson.JsonTable;
import com.raihanMuhammadIhsanJBusAF.dbjson.Serializable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A generic interface for providing basic CRUD operations with RESTful endpoints.
 *
 * @param <T> the type of the entity that this interface handles
 */
@RestController
public interface BasicGetController<T extends Serializable> {
    /**
     * Retrieves the JsonTable associated with the entity type.
     *
     * @return the JsonTable associated with the entity type
     */
    public abstract JsonTable<T> getJsonTable ();
    /**
     * Retrieves an entity by its ID.
     *
     * @param id the ID of the entity to retrieve
     * @return the retrieved entity or null if not found
     */
    @GetMapping("/{id}")
    public default T getById(@PathVariable int id) {
        return Algorithm.<T>find(getJsonTable(), e -> e.id == id);
    }
    /**
     * Retrieves a paginated list of entities.
     *
     * @param page     the page number (0-based)
     * @param pageSize the size of each page
     * @return a list of entities for the specified page
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public default List<T> getPage(
            @RequestParam (value = "page", defaultValue = "0") int page,
            @RequestParam (value = "size", defaultValue = "5") int pageSize){
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, t->true);
    }


}
