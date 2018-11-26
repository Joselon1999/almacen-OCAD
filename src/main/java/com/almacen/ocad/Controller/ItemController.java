package com.almacen.ocad.Controller;

import com.almacen.ocad.Entity.Item;
import com.almacen.ocad.Service.ItemService;
import com.almacen.ocad.paginator.PageRender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/almacen")
    public String items(
            //@RequestParam(name = "page", defaultValue = "0") int page,
                        Model model) {
/*
        Pageable pageRequest = new PageRequest(page, 10);
        Page<Item> items = itemService.findAllPageable(pageRequest);
        PageRender<Item> pageRender = new PageRender<Item>("/almacen", items);
*/
        model.addAttribute("items", itemService.findAll());
        /*model.addAttribute("items", item);
        *model.addAttribute("page", pageRender);
         */
        return "almacen";
    }

    @RequestMapping(value = "/form")
    public String crear(Map<String, Object> model) {

        Item item = new Item();
        model.put("items", item);
        model.put("titulo", "Crear Cliente");
        return "form";
    }

    @PutMapping(value = "/form/{id}")
    public String editar(@PathVariable(value = "id") String id, Map<String, Object> model, RedirectAttributes flash) {

        Optional<Item> item = null;

        if (!id.equals("0")) {
            item = itemService.findItemById(id);
            if (item == null) {
                flash.addFlashAttribute("error", "El ID del item no existe!");
                return "redirect:/almacen";
            }
        } else {
            flash.addFlashAttribute("error", "El ID del item no puede ser cero!");
            return "redirect:/almacen";
        }
        model.put("item", item);
        model.put("titulo", "Editar Item");
        return "form";
    }

    @PostMapping(value = "/form")
    public String guardar(@Valid Item item, BindingResult result, Model model,
                          RedirectAttributes flash, SessionStatus status) {

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Cliente");
            return "almacen";
        }


        String mensajeFlash = (item.getId() != 0) ? "Item editado con éxito!" : "Item creado con éxito!";

        itemService.save(item);
        status.setComplete();
        flash.addFlashAttribute("success", mensajeFlash);
        return "redirect:/almacen";

    }
}

