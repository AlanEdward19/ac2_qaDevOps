package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.AlunoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import service.AlunoService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AlunoController.class)
@ContextConfiguration(classes = AlunoController.class)
public class AlunoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlunoService alunoService;

    private ObjectMapper objectMapper = new ObjectMapper();

    private AlunoDto alunoDto;

    @BeforeEach
    public void setup() {
        alunoDto = new AlunoDto("João Silva", "joao@example.com");
    }

    @Test
    public void listarAlunos_DeveRetornarListaDeAlunos() throws Exception {
        List<AlunoDto> alunos = Arrays.asList(alunoDto);
        when(alunoService.listarAlunos()).thenReturn(alunos);

        mockMvc.perform(get("/students")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(alunos)));

        verify(alunoService, times(1)).listarAlunos();
    }

    @Test
    public void salvarAluno_DeveSalvarAlunoComSucesso() throws Exception {
        mockMvc.perform(post("/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(alunoDto)))
                .andExpect(status().isOk());

        verify(alunoService, times(1)).salvarAluno(any(AlunoDto.class));
    }

    @Test
    public void deletarAluno_DeveDeletarAlunoPorId() throws Exception {
        Long alunoId = 1L;

        mockMvc.perform(delete("/students")
                        .param("id", String.valueOf(alunoId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(alunoService, times(1)).deletarAluno(alunoId);
    }

    @Test
    public void atualizarAluno_DeveAtualizarAlunoComSucesso() throws Exception {
        Long alunoId = 1L;

        mockMvc.perform(put("/students")
                        .param("id", String.valueOf(alunoId))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(alunoDto)))
                .andExpect(status().isOk());

        verify(alunoService, times(1)).atualizarAluno(eq(alunoId), refEq(alunoDto));
    }
}
