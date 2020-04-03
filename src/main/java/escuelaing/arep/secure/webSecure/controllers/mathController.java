package escuelaing.arep.secure.webSecure.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import escuelaing.arep.secure.webSecure.service.connectionService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/math")
public class mathController {

  @Autowired
  connectionService cs;

  @GetMapping("/{a}&{b}")
  public ResponseEntity<?> sumEntity(@PathVariable Double a, @PathVariable Double b) {
    try {
      return new ResponseEntity<>(cs.sum(a,b), HttpStatus.OK);
    } catch (Exception ex) {
      Logger.getLogger(mathController.class.getName()).log(Level.SEVERE, null, ex);
      return new ResponseEntity<>("No user exist", HttpStatus.NOT_FOUND);
    }
  }

}