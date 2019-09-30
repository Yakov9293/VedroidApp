package com.example.assholeapp.mappers;

import com.example.assholeapp.api.CatApi;
import com.example.assholeapp.api.CatsApi;
import com.example.assholeapp.db.CatDb;

import java.util.ArrayList;
import java.util.List;

public class CatApiToDbMapper {

    public static List<CatDb> catsApiToDb(List<CatApi> catsApi) {
        List<CatDb> resultList = new ArrayList<>();
        for (CatApi cat: catsApi){
            resultList.add(catApiToDb(cat));
        }
        return resultList;
    }

    private static CatDb catApiToDb(CatApi catApi) {
        CatDb resultCat = new CatDb();
        resultCat.imageUrl = catApi.imageUrl;
        return resultCat;
    }

}
