package com.FebrianaJmartKD.controller;

/**
 * class BasicGetController
 * Untuk mendapatkan id dan page (Get method)
 *
 * @author Febriana Pasonang Sidauruk
 *
 */

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
    default @ResponseBody List<T> getPage (@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue="5") int pageSize){
        return Algorithm.<T>paginate(getJsonTable(),page,pageSize,e -> true);
    }

    public abstract JsonTable<T> getJsonTable();
}
