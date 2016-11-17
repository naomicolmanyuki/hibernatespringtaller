package py.edu.facitec.hibernatespringtaller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import py.edu.facitec.hibernatespringtaller.dao.ProductoDAO;
import py.edu.facitec.hibernatespringtaller.model.Pedido;
import py.edu.facitec.hibernatespringtaller.model.Producto;


@RestController
@Transactional
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	private ProductoDAO productoDao;
	
		@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)	
		//permite asignar json a un objeto	
		public ResponseEntity<Producto> registrar(@RequestBody Producto producto){
			System.out.println(producto);
			productoDao.guardar(producto, producto.getId());
			
			return new ResponseEntity<Producto>(producto, HttpStatus.OK);
		}
		
		//Recupera la Lista de Pedidos
		@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Producto>> obtenerTodos(){

			List<Producto> producto= productoDao.buscarTodos();
			
			
			return new ResponseEntity<List<Producto>>(producto,HttpStatus.OK);
		}
		
		//Buscar por Id
		@RequestMapping(method=RequestMethod.GET,value="/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)

												//asigna el id de la url al parametro
		public ResponseEntity<Producto> buscarPorId(@PathVariable Integer id){
			
			
		Producto producto =	productoDao.buscar(id);
		    
				System.out.println(producto);
			
		  return  new ResponseEntity<Producto>(producto, HttpStatus.OK);
		}
		
		//Eliminar

		@RequestMapping(method=RequestMethod.DELETE,value="/{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
		   public ResponseEntity<Producto> eliminar(@PathVariable Integer id){
			
			
			Producto producto = productoDao.buscar(id);
			
			if(producto==null){
			return	new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			   
			productoDao.eliminar(producto);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}

		@RequestMapping("/form")
		public ModelAndView formulario(){

			return new ModelAndView("/producto/form");
		}

	
	
	
	
	
	
}
