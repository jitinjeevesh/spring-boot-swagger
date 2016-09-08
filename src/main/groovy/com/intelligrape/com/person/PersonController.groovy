package com.intelligrape.com.person

import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import com.wordnik.swagger.annotations.ApiResponse
import com.wordnik.swagger.annotations.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Api(basePath = "swagger-demo/person", value = "Content", description = "Operations with content", produces = "application/json")
@RestController
@RequestMapping(value = "swagger-demo/person", produces = MediaType.APPLICATION_JSON_VALUE)
class PersonController {

    @RequestMapping(method = RequestMethod.GET, value = "/show")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ApiOperation(value = "Get Content", notes = "Fetch List of Content")
    @ApiResponses(value = [
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 201, message = "List"),
            @ApiResponse(code = 500, message = "Error occurred while fetching Content")
    ])
    ResponseEntity<Person> show() {
        return new ResponseEntity<Person>(new Person(firstName: 'Jeevesh', lastName: 'Pandey', age: 27), HttpStatus.OK)
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ApiOperation(value = "Get Content", notes = "Fetch List of Content")
    @ApiResponses(value = [
            @ApiResponse(code = 400, message = "Fields are with validation errors"),
            @ApiResponse(code = 201, message = "List"),
            @ApiResponse(code = 500, message = "Error occurred while fetching Content")
    ])
    ResponseEntity<Person> create(@RequestBody PersonCO co) {
        println("personCO:::::::::${co?.properties}")
        return new ResponseEntity<Person>(new Person(firstName:co.firstName,lastName: co.lastName,age: co.age ), HttpStatus.OK)
    }
}
