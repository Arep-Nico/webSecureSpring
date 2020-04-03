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

  @GetMapping("sum/{a}&{b}")
  public ResponseEntity<?> sumEntity(@PathVariable String a, @PathVariable String b) {
    try {
      return new ResponseEntity<>(cs.sum(a,b), HttpStatus.OK);
    } catch (Exception ex) {
      Logger.getLogger(mathController.class.getName()).log(Level.SEVERE, null, ex);
      return new ResponseEntity<>("No user exist", HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("substrac/{a}&{b}")
  public ResponseEntity<?> substracEntity(@PathVariable String a, @PathVariable String b) {
    try {
      return new ResponseEntity<>(cs.substrac(a,b), HttpStatus.OK);
    } catch (Exception ex) {
      Logger.getLogger(mathController.class.getName()).log(Level.SEVERE, null, ex);
      return new ResponseEntity<>("No user exist", HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("multiply/{a}&{b}")
  public ResponseEntity<?> multiplyEntity(@PathVariable String a, @PathVariable String b) {
    try {
      return new ResponseEntity<>(cs.multiply(a, b), HttpStatus.OK);
    } catch (Exception ex) {
      Logger.getLogger(mathController.class.getName()).log(Level.SEVERE, null, ex);
      return new ResponseEntity<>("No user exist", HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("divide/{a}&{b}")
  public ResponseEntity<?> divideEntity(@PathVariable String a, @PathVariable String b) {
    try {
      return new ResponseEntity<>(cs.divide(a, b), HttpStatus.OK);
    } catch (Exception ex) {
      Logger.getLogger(mathController.class.getName()).log(Level.SEVERE, null, ex);
      return new ResponseEntity<>("No user exist", HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("square/{a}")
  public ResponseEntity<?> squareEntity(@PathVariable String a) {
    try {
      return new ResponseEntity<>(cs.square(a), HttpStatus.OK);
    } catch (Exception ex) {
      Logger.getLogger(mathController.class.getName()).log(Level.SEVERE, null, ex);
      return new ResponseEntity<>("No user exist", HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("exponent/{a}&{b}")
  public ResponseEntity<?> exponentEntity(@PathVariable String a, @PathVariable String b) {
    try {
      return new ResponseEntity<>(cs.exponent(a, b), HttpStatus.OK);
    } catch (Exception ex) {
      Logger.getLogger(mathController.class.getName()).log(Level.SEVERE, null, ex);
      return new ResponseEntity<>("No user exist", HttpStatus.NOT_FOUND);
    }
  }

}