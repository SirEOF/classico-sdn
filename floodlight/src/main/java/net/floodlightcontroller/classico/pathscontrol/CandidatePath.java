package net.floodlightcontroller.classico.pathscontrol;

import java.util.ArrayList;
import java.util.List;

import org.projectfloodlight.openflow.types.DatapathId;

import net.floodlightcontroller.classico.sessionmanager.UserSession;
import net.floodlightcontroller.core.types.NodePortTuple;
import net.floodlightcontroller.linkdiscovery.Link;
import net.floodlightcontroller.routing.Path;

public class CandidatePath extends Path{
	
	private long bandwidthConsumption;
	private List<Link> links;
	private List<DatapathId> switchesRefs;
	private UserSession userSession;
	
	public CandidatePath(DatapathId src, DatapathId dst) {
		super(src, dst);
		initswitchesRefs();
	}
	
//	public CandidatePath(Path path) {
//		super(path.getId(), path.getPath());
//		setHopCount(path.getHopCount());
//		setLatency(path.getLatency());
//		initswitchesRefs();
//	}
	
	public CandidatePath(UserSession userSession, Path path) {
		super(path.getId(), path.getPath());
		setHopCount(path.getHopCount());
		setLatency(path.getLatency());
		initswitchesRefs();
		this.setUserSession(userSession);
	}

	public long getBandwidthConsumption() {
		return bandwidthConsumption;
	}

	public void setBandwidthConsumption(long bandwidthConsumption) {
		this.bandwidthConsumption = bandwidthConsumption;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
		
	}
	
	private void initswitchesRefs(){
		switchesRefs = new ArrayList<>();
		for (NodePortTuple npt : getPath()) {
			if(!switchesRefs.contains(npt.getNodeId()))
				switchesRefs.add(npt.getNodeId());
		}
	}
	
	public List<DatapathId> getSwitchesRefs(){
		return switchesRefs;
	}
	
	public String getStringResumePath(){
		String resume = "Path: ";
		for (DatapathId did : switchesRefs) {
			resume+=did.toString().substring(did.toString().length()-2)+" ";
		}
		return resume;
	}

	public UserSession getUserSession() {
		return userSession;
	}

	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
	}
	
	

}
