import com.au.cities.domain.repository.CityRepository
import com.au.cities.domain.usecase.LoadDataUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

class LoadDataUseCaseTest {

    @Mock
    private val cityRepository = mock(CityRepository::class.java)
    private var loadDataUseCase = LoadDataUseCase(cityRepository)

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        loadDataUseCase = LoadDataUseCase(cityRepository)
    }

    @Test
    fun getItemsAsc(): Unit =runBlocking {
        loadDataUseCase.addAllCities()
        Mockito.verify(cityRepository).loadAllCities()
    }
}