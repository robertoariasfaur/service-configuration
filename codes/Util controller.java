
 @GetMapping
    public ResponseEntity<Iterable<Gateway>> getGateways(){
        var resp = gatewayRepository.findAll();
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
-----------------------------------------------------------------------	----------

@PostMapping
    public ResponseEntity<String> createGateway(@RequestBody Gateway gateway){
        try {
            gatewayRepository.save(gateway);
            return new ResponseEntity<String>("",HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_MODIFIED);
        }
    }
	
---------------------------------------------------------------------------------------
 @PostMapping(value = "/cambiar")
    ResponseEntity<String> mofificar( @RequestParam(value = "id_tarea") Integer id_tarea) { }
	
---------------------------------------------------------------------------------------



@RequestMapping(value = "/delete/palabra/acepcion", method = RequestMethod.DELETE)
ResponseEntity<AnotacionDeleteRespuesta> deleteAcepcionePalabra(@RequestParam("id_acepcion") String id_acepcion) {
        var result = service.deleteAcepcion(id_acepcion);
        return new ResponseEntity(result, HttpStatus.OK);
    }
	
