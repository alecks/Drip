package gg.owo.drip

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class ApiController {

    @PostMapping("/id")
    fun createID(@RequestBody request: NewDripId): DripId = DripId(request)

}