package com.outr.arango.api.model

/**
  * PostAPIViewPropsConsolidations
  *
  * @param type The segment candidates for the "consolidation" operation are selected based
  *        upon several possible configurable formulas as defined by their types.
  *        The currently supported types are (default: "bytes_accum"):
  *        - *bytes_accum*: consolidate if and only if ({threshold} range `[0.0, 1.0]`):
  *          {threshold} > (segment_bytes + sum_of_merge_candidate_segment_bytes) / all_segment_bytes
  *          i.e. the sum of all candidate segment byte size is less than the total
  *               segment byte size multiplied by the {threshold}
  *        - *tier*: consolidate based on segment byte size and live document count
  *                  as dicated by the customization attributes.
  *
  * WARNING: This code is generated by youi-plugin's generateHttpClient. Do not modify directly.
  */
case class PostAPIViewPropsConsolidations(`type`: Option[String] = None)