package com.apple.spring_shop;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;

    //(참고)Lombok없이 등록하려면
    //new ItemRepository() 하나 뽑아서 itemRepository 변수에 넣으라고 시키는 중임.
//    @Autowired
//    public ItemController(ItemRepository itemRepository) {
//        this.itemRepository = itemRepository;
//    }

    @GetMapping("/list")
    String list(Model model){
        List<Item> result = itemRepository.findAll(); //Lombok 문법, 테이블 모든 데이터 갖고 옴

        //System.out.println(result.get(0).price);
        //System.out.println(result.get(0).title);

        model.addAttribute("items",result);
        var a = new Item();
        System.out.println(a.toString());

        return "list.html";
    }
}
