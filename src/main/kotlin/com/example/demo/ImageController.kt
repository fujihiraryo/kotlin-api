package com.example.demo

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.multipart.MultipartFile
import org.springframework.http.ResponseEntity

import java.io.FileOutputStream

@RestController
class ImageController {

    @PostMapping("/image")
    fun upload(file: MultipartFile): ResponseEntity<String> {
        val path = "src/main/resources"
        val name = "aaa"
        val ext = when (file.contentType) {
            "image/png" -> "png"
            "image/jpeg" -> "jpg"
            else -> return ResponseEntity.badRequest().body(
                "content type '${file.contentType}' is invalid."
            )
        }
        FileOutputStream("${path}/${name}.${ext}").write(file.getBytes())
        return ResponseEntity.ok(name)
    }

}
