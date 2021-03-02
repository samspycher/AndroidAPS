package info.nightscout.androidaps.db;

import androidx.annotation.NonNull;

import com.j256.ormlite.dao.CloseableIterator;

import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import info.nightscout.androidaps.MainApp;
import info.nightscout.androidaps.interfaces.ActivePluginProvider;
import info.nightscout.androidaps.interfaces.DatabaseHelperInterface;
import info.nightscout.androidaps.plugins.general.nsclient.NSUpload;

@Singleton
public class DatabaseHelperProvider implements DatabaseHelperInterface {

    @Inject DatabaseHelperProvider() {
    }

    @Override public void createOrUpdate(@NonNull CareportalEvent careportalEvent) {
        MainApp.getDbHelper().createOrUpdate(careportalEvent);
    }

    @Override public void createOrUpdate(@NonNull DanaRHistoryRecord record) {
        MainApp.getDbHelper().createOrUpdate(record);
    }

    @Override public void createOrUpdate(@NonNull OmnipodHistoryRecord record) {
        MainApp.getDbHelper().createOrUpdate(record);
    }

    @NonNull @Override public List<DanaRHistoryRecord> getDanaRHistoryRecordsByType(byte type) {
        return MainApp.getDbHelper().getDanaRHistoryRecordsByType(type);
    }

    @NonNull @Override public List<TDD> getTDDs() {
        return MainApp.getDbHelper().getTDDs();
    }

    @Override public long size(@NonNull String table) {
        return MainApp.getDbHelper().size(table);
    }

    @Override public void create(@NonNull DbRequest record) {
        try {
            MainApp.getDbHelper().create(record);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override public void deleteAllDbRequests() {
        MainApp.getDbHelper().deleteAllDbRequests();
    }

    @Override public int deleteDbRequest(@NonNull String id) {
        return MainApp.getDbHelper().deleteDbRequest(id);
    }

    @Override public void deleteDbRequestbyMongoId(@NonNull String action, @NonNull String _id) {
        MainApp.getDbHelper().deleteDbRequestbyMongoId(action, _id);
    }

    @NonNull @Override public CloseableIterator<DbRequest> getDbRequestInterator() {
        return MainApp.getDbHelper().getDbRequestInterator();
    }

    @Override public long roundDateToSec(long date) {
        return MainApp.getDbHelper().roundDateToSec(date);
    }

    @Override public void createOrUpdateTDD(@NonNull TDD record) {
        MainApp.getDbHelper().createOrUpdateTDD(record);
    }

    @Override public boolean createOrUpdate(@NonNull TemporaryBasal tempBasal) {
        return MainApp.getDbHelper().createOrUpdate(tempBasal);
    }

    @NonNull @Override public TemporaryBasal findTempBasalByPumpId(long id) {
        return MainApp.getDbHelper().findTempBasalByPumpId(id);
    }

    @NonNull @Override public List<TemporaryBasal> getTemporaryBasalsDataFromTime(long mills, boolean ascending) {
        return MainApp.getDbHelper().getTemporaryBasalsDataFromTime(mills, ascending);
    }

    @Override public CareportalEvent getCareportalEventFromTimestamp(long timestamp) {
        return MainApp.getDbHelper().getCareportalEventFromTimestamp(timestamp);
    }

    @NonNull @Override public List<OmnipodHistoryRecord> getAllOmnipodHistoryRecordsFromTimestamp(long timestamp, boolean ascending) {
        return MainApp.getDbHelper().getAllOmnipodHistoryRecordsFromTimeStamp(timestamp, ascending);
    }

    @Nullable @Override public OmnipodHistoryRecord findOmnipodHistoryRecordByPumpId(long pumpId) {
        return MainApp.getDbHelper().findOmnipodHistoryRecordByPumpId(pumpId);
    }

    @NonNull @Override public List<TDD> getTDDsForLastXDays(int days) {
        return MainApp.getDbHelper().getTDDsForLastXDays(days);
    }

    @NonNull @Override public List<ProfileSwitch> getProfileSwitchData(long from, boolean ascending) {
        return MainApp.getDbHelper().getProfileSwitchData(from, ascending);
    }

    @Override public void createOrUpdate(@NonNull InsightBolusID record) {
        MainApp.getDbHelper().createOrUpdate(record);
    }

    @Override public void createOrUpdate(@NonNull InsightPumpID record) {
        MainApp.getDbHelper().createOrUpdate(record);
    }

    @Override public void createOrUpdate(@NonNull InsightHistoryOffset record) {
        MainApp.getDbHelper().createOrUpdate(record);
    }

    @Override public void delete(@NonNull ExtendedBolus extendedBolus) {
        MainApp.getDbHelper().delete(extendedBolus);
    }

    @Nullable @Override public ExtendedBolus getExtendedBolusByPumpId(long pumpId) {
        return MainApp.getDbHelper().getExtendedBolusByPumpId(pumpId);
    }

    @Nullable @Override public InsightBolusID getInsightBolusID(@NonNull String pumpSerial, int bolusID, long timestamp) {
        return MainApp.getDbHelper().getInsightBolusID(pumpSerial, bolusID, timestamp);
    }

    @Nullable @Override public InsightHistoryOffset getInsightHistoryOffset(@NonNull String pumpSerial) {
        return MainApp.getDbHelper().getInsightHistoryOffset(pumpSerial);
    }

    @Nullable @Override public InsightPumpID getPumpStoppedEvent(@NonNull String pumpSerial, long before) {
        return MainApp.getDbHelper().getPumpStoppedEvent(pumpSerial, before);
    }

    @Override public boolean createOrUpdate(@NonNull ExtendedBolus extendedBolus) {
        return MainApp.getDbHelper().createOrUpdate(extendedBolus);
    }

    @Override public void createOrUpdate(@NonNull ProfileSwitch profileSwitch) {
        MainApp.getDbHelper().createOrUpdate(profileSwitch);
    }

    @Override public void delete(@NonNull TemporaryBasal tempBasal) {
        MainApp.getDbHelper().delete(tempBasal);
    }

    @NonNull @Override public List<ExtendedBolus> getExtendedBolusDataFromTime(long mills, boolean ascending) {
        return MainApp.getDbHelper().getExtendedBolusDataFromTime(mills, ascending);
    }

    @Override public void deleteTempBasalById(@NonNull String _id) {
        MainApp.getDbHelper().deleteTempBasalById(_id);
    }

    @Override public void deleteExtendedBolusById(@NonNull String _id) {
        MainApp.getDbHelper().deleteExtendedBolusById(_id);
    }

    @Override public void deleteCareportalEventById(@NonNull String _id) {
        MainApp.getDbHelper().deleteCareportalEventById(_id);
    }

    @Override public void deleteProfileSwitchById(@NonNull String _id) {
        MainApp.getDbHelper().deleteProfileSwitchById(_id);
    }

    @Override public void createTempBasalFromJsonIfNotExists(@NonNull JSONObject json) {
        MainApp.getDbHelper().createTempBasalFromJsonIfNotExists(json);
    }

    @Override public void createExtendedBolusFromJsonIfNotExists(@NonNull JSONObject json) {
        MainApp.getDbHelper().createExtendedBolusFromJsonIfNotExists(json);
    }

    @Override public void createCareportalEventFromJsonIfNotExists(@NonNull JSONObject json) {
        MainApp.getDbHelper().createCareportalEventFromJsonIfNotExists(json);
    }

    @Override public void createProfileSwitchFromJsonIfNotExists(@NonNull ActivePluginProvider activePluginProvider, @NonNull NSUpload nsUpload, @NonNull JSONObject trJson) {
        MainApp.getDbHelper().createProfileSwitchFromJsonIfNotExists(activePluginProvider, nsUpload, trJson);
    }

    @Override public void resetDatabases() {
        MainApp.getDbHelper().resetDatabases();
    }
}
