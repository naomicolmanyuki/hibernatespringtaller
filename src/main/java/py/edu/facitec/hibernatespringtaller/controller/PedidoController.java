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

import py.edu.facitec.hibernatespringtaller.dao.PedidoDAO;
import py.edu.facitec.hibernatespringtaller.model.Pedido;

//Clase encargada de manipular peticiones del tipo Rest

@RestController
@Transactional
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoDAO pedidoDAO;

	//Registrar un Pedido solo en JSON
	
@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)	
									//permite asignar json a un objeto	
public ResponseEntity<Pedido> registrar(@RequestBody Pedido pedido){
		
	
	System.out.println(pedido);
	pedidoDAO.guardar(pedido, pedido.getId());
		
	return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
	}

//Recupera la Lista de Pedidos
@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<Pedido>> obtenerTodos(){

	List<Pedido> pedidos=pedidoDAO.buscarTodos();
	
	
	return new ResponseEntity<List<Pedido>>(pedidos,HttpStatus.OK);
}

//Buscar por Id
@RequestMapping(method=RequestMethod.GET,value="/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)

										//asigna el id de la url al parametro
public ResponseEntity<Pedido> buscarPorId(@PathVariable Integer id){
	
	
Pedido pedido=	pedidoDAO.buscar(id);
    
		System.out.println(pedido);
	
  return  new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
}


//Eliminar

@RequestMapping(method=RequestMethod.DELETE,value="/{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Pedido> eliminar(@PathVariable Integer id){
	
	
	Pedido pedido=pedidoDAO.buscar(id);
	
	if(pedido==null){
	return	new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	   
	pedidoDAO.eliminar(pedido);
	
	return new ResponseEntity<>(HttpStatus.OK);
}

@RequestMapping("/form")
public ModelAndView formulario(){

	return new ModelAndView("/pedido/form");
}


	
	
	
	

}
