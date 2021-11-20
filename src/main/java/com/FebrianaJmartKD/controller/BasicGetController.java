package com.FebrianaJmartKD.controller;

import java.util.List;
import com.FebrianaJmartKD.dbjson.JsonTable;
import com.FebrianaJmartKD.dbjson.Serializable;
import com.FebrianaJmartKD.Algorithm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface BasicGetController<T extends Serializable> {

    @GetMapping("/page")
    default List<T> getPage(int page, int pageSize) {
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, e->true);
    }

    @GetMapping("/id")
    default T getById (int id){
        return Algorithm.<T>find(getJsonTable(), (e) -> e.id==id);
    }

    public abstract JsonTable<T> getJsonTable ();
}
