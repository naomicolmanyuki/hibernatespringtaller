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

import py.edu.facitec.hibernatespringtaller.dao.GerenteDAO;
import py.edu.facitec.hibernatespringtaller.model.Gerente;



@RestController
@Transactional
@RequestMapping("/gerente")
public class GerenteController {
	@Autowired
	private GerenteDAO gerenteDAO;

	//Registrar un Pedido solo en JSON
	
@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)	
									//permite asignar json a un objeto	
public ResponseEntity<Gerente> registrar(@RequestBody Gerente gerente){
		
	
	System.out.println(gerente);
	gerenteDAO.guardar(gerente, gerente.getId());
		
	return new ResponseEntity<Gerente>(gerente, HttpStatus.OK);
	}

//Recupera la Lista de Pedidos
@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<Gerente>> obtenerTodos(){

	List<Gerente> gerentes=gerenteDAO.buscarTodos();
	
	
	return new ResponseEntity<List<Gerente>>(gerentes,HttpStatus.OK);
}

//Buscar por Id
@RequestMapping(method=RequestMethod.GET,value="/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)

										//asigna el id de la url al parametro
public ResponseEntity<Gerente> buscarPorId(@PathVariable Integer id){
	
	
Gerente gerente=gerenteDAO.buscar(id);
    
		System.out.println(gerente);
	
  return  new ResponseEntity<Gerente>(gerente, HttpStatus.OK);
}


//Eliminar

@RequestMapping(method=RequestMethod.DELETE,value="/{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Gerente> eliminar(@PathVariable Integer id){
	
	
	Gerente gerente=gerenteDAO.buscar(id);
	
	if(gerente==null){
	return	new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	   
	gerenteDAO.eliminar(gerente);
	
	return new ResponseEntity<>(HttpStatus.OK);
}

@RequestMapping("/form")
public ModelAndView formulario(){

	return new ModelAndView("/gerente/form");
}

}
