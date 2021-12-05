package com.FebrianaJmartKD.controller;

import java.util.List;
import com.FebrianaJmartKD.dbjson.JsonTable;
import com.FebrianaJmartKD.dbjson.Serializable;
import com.FebrianaJmartKD.Algorithm;
import org.springframework.web.bind.annotation.*;


@RestController

public interface BasicGetController<T extends Serializable> {
    @GetMapping("/{id}")
    default T getById(@PathVariable int id){
        return Algorithm.<T>find(getJsonTable(),(e) -> e.id == id);
    }

    @GetMapping("/page")
    default List<T> getPage (@PathVariable int page, @PathVariable int pageSize){
        return null;
    }

    public abstract JsonTable<T> getJsonTable();
}
