package info.nightscout.androidaps.plugins.pump.omnipod.eros.history

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import info.nightscout.androidaps.plugins.pump.omnipod.eros.history.database.ErosHistoryDatabase
import info.nightscout.androidaps.plugins.pump.omnipod.eros.history.database.ErosHistoryRecordDao
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ErosHistoryTest {

    private lateinit var dao: ErosHistoryRecordDao
    private lateinit var database: ErosHistoryDatabase

    @get:Rule
    val schedulerRule = RxSchedulerRule(Schedulers.trampoline())

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(
            context,
            ErosHistoryDatabase::class.java
        ).build()
        dao = database.historyRecordDao()
    }

    @Test
    fun testInsertionAndConverters() {
    }

    @Test
    fun testExceptionOnBolusWithoutRecord() {
    }

    @After
    fun tearDown() {
        database.close()
    }
}
