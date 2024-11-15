package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.CursoController;
import dto.CursoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import service.CursoService;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CursoController.class)
@ContextConfiguration(classes = CursoController.class)
public class CursoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CursoService cursoService;

    @Autowired
    private ObjectMapper objectMapper;

    private CursoDto cursoDto;

    @BeforeEach
    public void setUp() {
        cursoDto = new CursoDto("Curso de Java", "Descrição do curso de Java");
    }

    @Test
    public void listarCursos_DeveRetornarListaDeCursos() throws Exception {
        List<CursoDto> cursos = Collections.singletonList(cursoDto);
        when(cursoService.listarCursos()).thenReturn(cursos);

        mockMvc.perform(get("/courses"))
                .andExpect(status().isOk());

        verify(cursoService, times(1)).listarCursos();
    }

    @Test
    public void salvarCurso_DeveSalvarCursoComSucesso() throws Exception {
        mockMvc.perform(post("/courses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cursoDto)))
                .andExpect(status().isOk());

        verify(cursoService, times(1)).salvarCurso(refEq(cursoDto));
    }

    @Test
    public void deletarCurso_DeveDeletarCursoComSucesso() throws Exception {
        Long cursoId = 1L;

        mockMvc.perform(delete("/courses")
                        .param("id", String.valueOf(cursoId)))
                .andExpect(status().isOk());

        verify(cursoService, times(1)).deletarCurso(cursoId);
    }

    @Test
    public void atualizarCurso_DeveAtualizarCursoComSucesso() throws Exception {
        Long cursoId = 1L;

        mockMvc.perform(put("/courses")
                        .param("id", String.valueOf(cursoId))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cursoDto)))
                .andExpect(status().isOk());

        verify(cursoService, times(1)).atualizarCurso(eq(cursoId), refEq(cursoDto));
    }
}
