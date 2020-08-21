package com.example.demo

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.multipart.MultipartFile
import org.springframework.http.ResponseEntity

import java.io.FileOutputStream
import java.util.UUID
import javax.servlet.http.HttpServletRequest

@RestController
class ImageController {

    @PostMapping("/upload")
    fun upload(file: MultipartFile, request: HttpServletRequest): ResponseEntity<String> {
        val dir = "src/main/resources/static"
        val name = UUID.randomUUID().toString()
        val ext = when (file.contentType) {
            "image/png" -> "png"
            "image/jpeg" -> "jpg"
            else -> return ResponseEntity.badRequest().body(
                "content type '${file.contentType}' is invalid."
            )
        }
        FileOutputStream("${dir}/${name}.${ext}").write(file.getBytes())
        val url = request.requestURL.toString().replace("/upload", "")
        return ResponseEntity.ok("${url}/${name}.${ext}")
    }

}
