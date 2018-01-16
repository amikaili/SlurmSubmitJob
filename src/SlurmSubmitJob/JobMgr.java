package SlurmSubmitJob;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.ptr.ByteByReference;


public interface JobMgr extends LibCAPI, Library {
	
	JobMgr INSTANCE = Native.loadLibrary("CoreServices", JobMgr.class);
	
	public static class DynamicPluginData extends Structure {
        public Pointer data;
        public int plugin_id;
	    protected List getFieldOrder() { 
	        return Arrays.asList(new String[] { 
                "data", "plugin_id"
	        } );
	    }
		
	}
	
	public static class SYSTEMTIME extends Structure {
	    public short wYear;
	    public short wMonth;
	    public short wDayOfWeek;
	    public short wDay;
	    public short wHour;
	    public short wMinute;
	    public short wSecond;
	    public short wMilliseconds;
	    protected List getFieldOrder() { 
	        return Arrays.asList(new String[] { 
	            "wYear", "wMonth", "wDayOfWeek", "wDay", "wHour", "wMinute", "wSecond", "wMilliseconds",
	        });
	    }
	}

	void GetSystemTime(SYSTEMTIME result);	
	
	
    public static class JobDescriptor extends Structure {
        // public static final List<String> FIELDS = null;
    	public String account;
    	public String acctg_freq;
    	public String admin_comment;
    	public String alloc_node;
    	public short alloc_resp_port;
    	public int alloc_sid;
    	public int argc;
    	
    	public PointerByReference argv;

    	public String array_inx;
    	
    	public Pointer array_bitmap;
    	
    	public SYSTEMTIME begin_time;
    	
    	public int bitflags;
    	public String burst_buffer;
    	public short ckpt_interval;
    	public String ckpt_dir;
    	public String clusters;
    	public String comment;
    	public short contiguous;
    	public short core_spec;
    	public String cpu_bind;
    	public short cpu_bind_type;
    	
        public int cpu_freq_min;
        public int cpu_freq_max;
        public int cpu_freq_gov;

    	public SYSTEMTIME deadline;

        public int delay_boot;
        public String dependency;
        
    	public SYSTEMTIME end_time;
    	
    	public PointerByReference environment;
    	
    	public int env_size;
    	public String exc_nodes;
        public String features;
        public long fed_siblings;
        public String gres;
        public int group_id;
        public int group_number;
        public short immediate;
        
        public int job_id;
        
        public String job_id_str;
        
        public short kill_on_node_fail;
        public String licenses;
        
        public short mail_type;
        public String mail_user;
        
        public String mcs_label;
        public String mem_bind;
        public short mem_bind_type;
        
        public String name;
        
        public String network;
        
        public int nice;
        
        public int numpack;
        public int num_tasks;
        public byte open_mode;
        public short other_port;
        public byte overcommit;
        public int pack_leader;
        
        public String partition;
        
        public PointerByReference pelog_env;
        
        public int pelog_env_size;
        public short plane_size;
        public byte power_flags;
        
        public int priority;
        
        public int profile;
        
        public String qos;
        
        public short reboot;
        
        public String resp_host;
        public short restart_cnt;
        public byte resv_port;
        public String req_nodes;
        public short requeue;
        public String reservation;
        
        public String script;
        
        public short shared;
        
        public PointerByReference spank_job_env;
        
        public int spank_job_env_size;
        public int task_dist;
        public int time_limit;
        public int time_min;
        
        public int user_id;
        
        public short wait_all_nodes;
        public short warn_flags;
        public short warn_signal;
        public short warn_time;
        public String work_dir;
        
        public short cpus_per_task;
        public int min_cpus;
        public int max_cpus;
        public int min_nodes;
        public int max_nodes;
        public short boards_per_node;
        public short sockets_per_board;
        public short sockets_per_node;
        public short cores_per_socket;
        public short threads_per_core;
        public short ntasks_per_node;
        public short ntasks_per_socket;
        public short ntasks_per_core;
        public short ntasks_per_board;
        public short pn_min_cpus;
        public long pn_min_memory;
        public int pn_min_tmp_disk;
        
        public short[] geometry;
        public short[] conn_type;
        public short rotate;
        public String blrtsimage;
        public String linuximage;
        public String mloaderimage;
        public String ramdiskimage;
        
        public int req_switch;
        
        public DynamicPluginData select_jobinfo;
        
        public String std_err;
        public String std_in;
        public String std_out;
        
        public Pointer tres_req_cnt; // pointer to long
        public int wait4switch;
        public String wckey;
        

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList( new String[] { 
                    "account",
                    "acctg_freq",
                    "admin_comment",
                    "alloc_node",
                    "alloc_resp_port",
                    "alloc_sid",
                    "argc",
                    
                    "argv",
                    
                    "array_inx",
                    
                    "array_bitmap",
                    
                    "begin_time",
                    
                    "bitflags",
                    "burst_buffer",
                    "ckpt_interval",
                    "ckpt_dir",
                    "clusters",
                    "comment",
                    "contiguous",
                    "core_spec",
                    "cpu_bind",
                    "cpu_bind_type",
                    
                    "cpu_freq_min",
                    "cpu_freq_max",
                    "cpu_freq_gov",
                    
                    "deadline",
                    
                    "delay_boot",
                    "dependency",
                    
                    "end_time",
                    
                    "environment",
                    
                    "env_size",
                    "exc_nodes",
                    "features",
                    "fed_siblings",
                    "gres",
                    "group_id",
                    "group_number",
                    "immediate",
                    
                    "job_id",
                    
                    "job_id_str",
                    
                    "kill_on_node_fail",
                    "licenses",
                    
                    "mail_type",
                    "mail_user",
                    
                    "mcs_label",
                    "mem_bind",
                    "mem_bind_type",
                    
                    "name",
                    
                    "network",
                    
                    "nice",
                    
                    "numpack",
                    "num_tasks",
                    "open_mode",
                    "other_port",
                    "overcommit",
                    "pack_leader",
                    
                    "partition",
                    
                    "pelog_env",
                    
                    "pelog_env_size",
                    "plane_size",
                    "power_flags",
                    
                    "priority",
                    
                    "profile",
                    
                    "qos",
                    
                    "reboot",
                    
                    "resp_host",
                    "restart_cnt",
                    "resv_port",
                    "req_nodes",
                    "requeue",
                    "reservation",
                    
                    "script",
                    
                    "shared",
                    
                    "spank_job_env",
                    "spank_job_env_size",
                    "task_dist",
                    "time_limit",
                    "time_min",
                    
                    "user_id",
                    
                    "wait_all_nodes",
                    "warn_flags",
                    "warn_signal",
                    "warn_time",
                    "work_dir",
                    
                    "cpus_per_task",
                    "min_cpus",
                    "max_cpus",
                    "min_nodes",
                    "max_nodes",
                    "boards_per_node",
                    "sockets_per_board",
                    "sockets_per_node",
                    "cores_per_socket",
                    "threads_per_core",
                    "ntasks_per_node",
                    "ntasks_per_socket",
                    "ntasks_per_core",
                    "ntasks_per_board",
                    "pn_min_cpus",
                    "pn_min_memory",
                    "pn_min_tmp_disk",
                    
                    "geometry",
                    "conn_type",
                    "rotate",
                    "blrtsimage",
                    "linuximage",
                    "mloaderimage",
                    "ramdiskimage",
                    
                    "req_switch",
                    
                    "select_jobinfo",
                    
                    "std_err",
                    "std_in",
                    "std_out",
                    
                    "tres_req_cnt",
                    "wait4switch",
                    "wckey"
                } );
        }
        
    }
    

    
    /*****************************************************************************\
     *	RESOURCE ALLOCATION FUNCTIONS
    \*****************************************************************************/

    /*
     * slurm_init_job_desc_msg - initialize job descriptor with
     *	default values
     * OUT job_desc_msg - user defined job descriptor
     */
    void slurm_init_job_desc_msg( JobDescriptor job_desc_msg );
    
    
    
    void printf(String format, Object... args);

}
