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

import py.edu.facitec.hibernatespringtaller.dao.DepartamentoDAO;
import py.edu.facitec.hibernatespringtaller.model.Departamento;



@RestController
@Transactional
@RequestMapping("/departamento")
public class DepartamentoController {
	@Autowired
	private DepartamentoDAO departamentoDAO;

	//Registrar un Pedido solo en JSON
	
@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)	
									//permite asignar json a un objeto	
public ResponseEntity<Departamento> registrar(@RequestBody Departamento departamento){
		
	
	System.out.println(departamento);
	departamentoDAO.guardar(departamento, departamento.getId());
		
	return new ResponseEntity<Departamento>(departamento, HttpStatus.OK);
	}

@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<Departamento>> obtenerTodos(){

	List<Departamento> departamentos=departamentoDAO.buscarTodos();
	
	
	return new ResponseEntity<List<Departamento>>(departamentos,HttpStatus.OK);
}

//Buscar por Id
@RequestMapping(method=RequestMethod.GET,value="/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)

										//asigna el id de la url al parametro
public ResponseEntity<Departamento> buscarPorId(@PathVariable Integer id){
	
	
Departamento departamento=	departamentoDAO.buscar(id);
    
		System.out.println(departamento);
	
  return  new ResponseEntity<Departamento>(departamento, HttpStatus.OK);
}


//Eliminar

@RequestMapping(method=RequestMethod.DELETE,value="/{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Departamento> eliminar(@PathVariable Integer id){
	
	
	Departamento departamento=departamentoDAO.buscar(id);
	
	if(departamento==null){
	return	new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	   
	departamentoDAO.eliminar(departamento);
	
	return new ResponseEntity<>(HttpStatus.OK);
}

@RequestMapping("/form")
public ModelAndView formulario(){

	return new ModelAndView("/departamento/form");
}


}
