package py.edu.facitec.hibernatespringtaller.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import py.edu.facitec.hibernatespringtaller.dao.ItemPedidoDAO;
import py.edu.facitec.hibernatespringtaller.dao.PedidoDAO;
import py.edu.facitec.hibernatespringtaller.model.ItemPedido;
import py.edu.facitec.hibernatespringtaller.model.Pedido;

@RestController
@Transactional
@RequestMapping("/itemPedido")
public class ItemPedidoController {
	
	@Autowired
	private ItemPedidoDAO itemPedidoDAO;

	//Registrar un Pedido solo en JSON
	
	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemPedido> registrar(@RequestBody ItemPedido itemPedido){
		System.out.println(itemPedido);
		itemPedidoDAO.guardar(itemPedido, itemPedido.getId());
		
		return new ResponseEntity<ItemPedido>(itemPedido, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ItemPedido>> obtenerTodos(){

		List<ItemPedido> itemPedido=itemPedidoDAO.buscarTodos();
		
		
		return new ResponseEntity<List<ItemPedido>>(itemPedido,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)

	//asigna el id de la url al parametro
	public ResponseEntity<ItemPedido> buscarPorId(@PathVariable Integer id){
		ItemPedido itemPedido=	itemPedidoDAO.buscar(id);
		System.out.println(itemPedido);

		return  new ResponseEntity<ItemPedido>(itemPedido, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	   public ResponseEntity<ItemPedido> eliminar(@PathVariable Integer id){
		
		
		ItemPedido itemPedido=itemPedidoDAO.buscar(id);
		
		if(itemPedido==null){
		return	new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		   
		itemPedidoDAO.eliminar(itemPedido);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping("/form")
	public ModelAndView formulario(){

		return new ModelAndView("/itemPedido/form");
	}


}
